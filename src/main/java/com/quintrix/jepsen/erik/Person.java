package com.quintrix.jepsen.erik;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"personId", "fName", "lName", "deptId", "skills"})
public class Person {
  @JsonProperty("personId")
  private int personId;
  @JsonProperty("deptId")
  private int deptId;
  @JsonProperty("fName")
  private String fName;
  @JsonProperty("lName")
  private String lName;
  @JsonProperty("skills")
  private List<String> skills;

  public Person() {
    super();
    skills = new ArrayList<String>();
  }

  public Person(int personId, String fName, String lName, int deptId, String[] skills) {
    this();
    this.personId = personId;
    this.fName = fName;
    this.lName = lName;
    this.deptId = deptId;
    for (String skill : skills) {
      this.skills.add(skill);
    }
  }

  @JsonProperty("personId")
  public int getPersonId() {
    return personId;
  }

  @JsonProperty("personId")
  public void setPersonId(int personId) {
    this.personId = personId;
  }

  @JsonProperty("deptId")
  public int getDeptId() {
    return deptId;
  }

  @JsonProperty("deptId")
  public void setDeptId(int deptId) {
    this.deptId = deptId;
  }

  @JsonProperty("fName")
  public String getfName() {
    return fName;
  }

  @JsonProperty("fName")
  public void setfName(String fName) {
    this.fName = fName;
  }

  @JsonProperty("lName")
  public String getlName() {
    return lName;
  }

  @JsonProperty("lName")
  public void setlName(String lName) {
    this.lName = lName;
  }

  @JsonProperty("skills")
  public List<String> getSkills() {
    return skills;
  }
}
