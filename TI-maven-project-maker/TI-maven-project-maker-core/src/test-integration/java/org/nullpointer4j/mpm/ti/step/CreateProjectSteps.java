package org.nullpointer4j.mpm.ti.step;

import org.junit.Assert;
import org.npe4j.mpmaker.bean.BasicPOMInformation;
import org.npe4j.mpmaker.bean.BasicPOMInformationImp;
import org.npe4j.mpmaker.commons.StringUtil;
import org.npe4j.mpmaker.core.POMBuilderFactory;
import org.npe4j.mpmaker.core.POMBuilderFactoryImp;
import org.npe4j.mpmaker.core.POMTransformer;
import org.npe4j.mpmaker.core.POMTransformerImp;
import org.npe4j.mpmaker.core.builder.XMLProjectObjectModelBPBuilder;
import org.npe4j.mpmaker.core.enums.TypeProjectMaven;
import org.npe4j.mpmakerxml.xml.pom.XMLProjectObjectModel;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateProjectSteps {

    private final POMTransformer transformer = new POMTransformerImp();
    private final POMBuilderFactory factory = new POMBuilderFactoryImp();

    private XMLProjectObjectModelBPBuilder builder;

    private TypeProjectMaven type;
    private String group;
    private String artifactId;
    private String version;
    private String packing;
    private XMLProjectObjectModel pom;

    public CreateProjectSteps() {
        super();
    }

    @Given("^project type is \"([^\"]*)\".$")
    public void type(
        final String type) {
        this.type = TypeProjectMaven.valueOf(type);
    }

    @Given("^project group is \"([^\"]*)\".$")
    public void group(
        final String group) {
        this.group = group;
    }

    @Given("^project id is \"(.*?)\".$")
    public void name(
        final String artifactId) {
        this.artifactId = artifactId;
    }

    @Given("^project version is \"(.*?)\".$")
    public void version(
        final String version) {
        this.version = version;
    }

    @Given("^packaging is \"(.*?)\".$")
    public void packing(
        final String packing) {
        this.packing = packing;
    }

    @When("^create the project.$")
    public void create() {
        BasicPOMInformation info = new BasicPOMInformationImp(group, artifactId, version, packing);
        pom =  factory.make(type, info).build();
    }

    @Then("^xml should be \"(.*?)\"\\.$")
    public void xmlShouldBe(
        final String xml) {
        String actual = StringUtil.normalizeXML(transformer.toXML(pom));
        Assert.assertEquals(xml, actual);
    }
}
