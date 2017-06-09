package org.deleterdirectory.it.step;

import org.junit.Assert;
import org.npe4j.mpmaker.MavenProjectMaker;
import org.npe4j.mpmaker.commons.StringUtil;
import org.npe4j.mpmaker.commons.dp.BeanDPBuilder;
import org.npe4j.mpmaker.commons.io.GenericFileMarshaller;
import org.npe4j.mpmaker.commons.io.jaxb.GenericJAXBMarshaller;
import org.npe4j.mpmaker.commons.xml.XMLMarshaller;
import org.npe4j.mpmaker.core.BasicPOMInformation;
import org.npe4j.mpmaker.core.BasicPOMInformationImp;
import org.npe4j.mpmaker.core.POMBuilderFactory;
import org.npe4j.mpmaker.core.POMBuilderFactoryImp;
import org.npe4j.mpmaker.core.POMTransformer;
import org.npe4j.mpmaker.core.POMTransformerImp;
import org.npe4j.mpmaker.core.enums.TypeProjectMaven;
import org.npe4j.mpmaker.core.xml.pom.XMLProjectObjectModel;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateProjectSteps {

    private final MavenProjectMaker test;
    private final POMTransformer transformer = new POMTransformerImp(new GenericJAXBMarshaller());
    private final POMBuilderFactory factory = new POMBuilderFactoryImp();
    private TypeProjectMaven type;
    private String group;
    private String artifactId;
    private String version;
    private String packing;
    private XMLProjectObjectModel pom;

    public CreateProjectSteps() {
        super();
        GenericFileMarshaller xmlReader = new GenericJAXBMarshaller();
        test = new MavenProjectMaker(new XMLMarshaller(xmlReader));
    }

    @Given("^project type is \"([^\"]*)\".$")
    public void type(
        final String type)
        throws Throwable {
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
        BeanDPBuilder<XMLProjectObjectModel> in = factory.make(type, info);
        pom = transformer.transform(in);
    }

    @Then("^xml should be \"(.*?)\"\\.$")
    public void xmlShouldBe(
        final String xml) {
        String actual = StringUtil.normalizeXML(transformer.toXML(pom));
        Assert.assertEquals(xml, actual);
    }
}
