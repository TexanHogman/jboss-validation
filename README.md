This set of projects was built to demonstrate unexpected EE6 behavior when components are deployed via jboss modules.

You should see this top level project which is a multi module and parent pom, a ee6 application called module-test and two dependent projects foo and bar.

The application consist of a single servlet available at http://localhost:8080/module-test/doit which injects Foo which in turn injects Bar.

When a mvn install in run the jboss modules are built and published to the jboss install location described in the property section of the parent pom.xml 
