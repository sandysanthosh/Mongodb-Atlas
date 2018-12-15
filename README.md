# mongodb


https://github.com/sandysanthosh/mongodb.wiki.git



->java mongodb:

->mongo java driver

->go to github ->release
-download the jar file

mongo-java-driver.jar

eclipse:    
    new java file
    librarires->mongo java driver
    new class->mongodb class

            main(){
            MongoClient mongoClient = new MongoClient("localhost", 27010);
            DB db = mongoClient.getDB("test");    // select the database name
            System.out.println("connected to database");
            }
            catch(Exception e)
            {
            System.out.println(e);
            }

