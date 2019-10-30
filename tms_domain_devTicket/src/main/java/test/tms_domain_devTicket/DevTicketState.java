package test.tms_domain_devTicket;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;

import test.suman.tms_domain.base.InputParams;
import test.suman.tms_domain.base.TicketContext;
import test.suman.tms_domain.base.TicketState;
import test.tms_domain_devTicket.request.DevAssignmentReq;
import test.tms_domain_devTicket.request.DevWorkDoneReq;
import test.tms_domain_devTicket.request.PostToDevReq;
import test.tms_domain_devTicket.request.QAAssignmentReq;
import test.tms_domain_devTicket.request.QAWorkDoneReq;

@JsonTypeName("dev")
public enum DevTicketState implements TicketState {

	CREATED {

		@Override
		public TicketState doInvokeActions(TicketContext ctx, InputParams ip) {
			// TODO code to post to dev team queue
			ctx.setAttributeValue("devTargetType", ((PostToDevReq)ip).getDevTargetType());
			ctx.setAttributeValue("devTargetName", ((PostToDevReq)ip).getDevTargetName());
			return DevTicketState.DEV_POSTED;

		}

	},
	DEV_POSTED {

		@Override
		public TicketState doInvokeActions(TicketContext ctx, InputParams ip) {

			ctx.setAttributeValue("assignedDevId", ((DevAssignmentReq) ip).getDevId());
			return DevTicketState.DEV_ASSIGNED;
		}
	},
	DEV_ASSIGNED {
		@Override
		public TicketState doInvokeActions(TicketContext devTkt, InputParams ip) {

			devTkt.setAttributeValue("devCommitHash", ((DevWorkDoneReq) ip).getCommitHash());
			devTkt.setAttributeValue("devComment", ((DevWorkDoneReq) ip).getComment());

			return DevTicketState.DEV_WORK_DONE;

		}

	},
	DEV_WORK_DONE {
		@Override
		public TicketState doInvokeActions(TicketContext ctx, InputParams ip) {
			// devTkt.setAttributeValue("devCommitHash",
			// ((PostToQAReq)ip).getQaTeamTargetName());
			return DevTicketState.QA_POSTED;

		}

	},
	QA_POSTED {
		private Map<String, TicketState> outbounds = new HashMap<String, TicketState>() {
			{
				put("qaAssignment", DevTicketState.QA_ASSIGNED);
			}
		};

		@Override
		public TicketState doInvokeActions(TicketContext ctx, InputParams ip) {
			ctx.setAttributeValue("qaName", ((QAAssignmentReq) ip).getQaId());
			return DevTicketState.QA_ASSIGNED;

		}

	},
	QA_ASSIGNED {
		@Override
		public TicketState doInvokeActions(TicketContext ctx, InputParams ip) {
			ctx.setAttributeValue("qaComment", ((QAWorkDoneReq) ip).getQaComment());
			ctx.setAttributeValue("isQAPassed", String.valueOf(((QAWorkDoneReq) ip).isQAPassed()));

			return DevTicketState.QA_WORK_DONE;

		}

	},
	QA_WORK_DONE {

		@Override
		public TicketState doInvokeActions(TicketContext ctx, InputParams ip) {

			if (Boolean.valueOf(ctx.getAttributeValue("isQAPassed"))) {
				return DevTicketState.COMPLETED;
			} else {
				return DevTicketState.DEV_POSTED;
			}

			// TODO Auto-generated method stub

		}

	},
	COMPLETED {
		@Override
		public TicketState doInvokeActions(TicketContext ctx, InputParams ip) {
			// TODO Auto-generated method stub
			throw new RuntimeException("Ticket in terminal state");

		}
	};

	@JsonValue
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name();
	}

	@Override
	public TicketState getFromName(String name) {
		// TODO Auto-generated method stub
		return DevTicketState.valueOf(name);
	}

	@JsonCreator
	public static DevTicketState fromName(@JsonProperty("name") String tktStr) {
		return DevTicketState.valueOf(tktStr);
	}

}
