1. cd src/main/docker;  
   docker-compose up
2. docker exec -it --user=solr docker_solr_1 bin/solr create_core -c Student
(docker_solr_1 is your container **name** - docker container ls)
3. To view in swagger, use this URL - http://localhost:8080/swagger-ui.html
4. api/docs - http://localhost:8080/v2/api-docs

Since, managed-schema is not defined, getAllStudents api resulted error. 
Have created a dummy student with id as 1 during start up.
ContextRefreshedEvent is used, so that the student with id=1 is created after all the beans are loaded in container.