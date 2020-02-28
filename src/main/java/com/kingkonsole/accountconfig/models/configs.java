package com.kingkonsole.accountconfig.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Configs {
    @Id
    public ObjectId _id;

    public String org_id;
    public String org_name;
    public String primary_color;

    // Constructors
    public Configs() {}

    public Configs(ObjectId _id, String org_id, String org_name, String primary_color) {
        this._id = _id;
        this.org_id = org_id;
        this.org_name = org_name;
        this.primary_color = primary_color;
    }

    // ObjectId needs to be converted to string
    public String get_id() { return _id.toHexString(); }
    public void set_id(ObjectId _id) { this._id = _id; }

    public String getOrgId() { return org_id; }
    public void setOrgId(String orgId) { this.org_id = orgId; }

    public String getOrgName() { return org_name; }
    public void setOrgName(String orgName) { this.org_name = orgName; }

    public String getPrimaryColor() { return primary_color; }
    public void setPrimaryColor(String primaryColor) { this.primary_color = primaryColor; }
}