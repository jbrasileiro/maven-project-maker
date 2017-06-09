package org.npe4j.mpmaker.bean;

public final class MavenProject {

    private String group;
    private String name;
    private String version;
    private String packing;

    public String getGroup() {
        return group;
    }

    public void setGroup(
        final String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(
        final String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(
        final String version) {
        this.version = version;
    }

    public String getPacking() {
        return packing;
    }

    public void setPacking(
        final String packing) {
        this.packing = packing;
    }
}
