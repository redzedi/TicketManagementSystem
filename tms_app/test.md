
curl -v -X POST  http://localhost:8080/tickets/1/execute -H "Content-Type:application/json" -d '{"devTargetType":"queue","devTargetName":"devQ","inputType":"dev_PostToDevReq"}'
curl -v -X POST  http://localhost:8080/tickets -H "Content-Type:application/json" -d '{"state":["dev","CREATED"]}'

 curl -v   http://localhost:8080/tickets/1 -H "Accept-Type:application/json"