Feature: Create a project

  Scenario Outline: Create a simple project
    Given project type is "<type>".
    Given project group is "<group>".
    Given project id is "<id>".
    Given project version is "<version>".
    Given packaging is "<packing>".
     When create the project.
     Then xml should be "<xml>".

    Examples: 
      | type | group       | id      | version | packing | xml                                                                                                                                                                                                                                                                                                                                                                                                                             |
      | NONE | org.example | example |   1.0.0 | pom     | <?xml version="1.0" encoding="UTF-8" standalone="yes"?><project xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd" xmlns="http://maven.apache.org/POM/4.0.0"><modelVersion>4.0.0</modelVersion><groupId>org.example</groupId><artifactId>example</artifactId><version>1.0.0</version><packaging>pom</packaging></project> |
