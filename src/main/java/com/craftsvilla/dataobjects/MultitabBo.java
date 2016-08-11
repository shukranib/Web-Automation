package com.craftsvilla.dataobjects;

public class MultitabBo {
String mainCategory;
String subCategory;
String links;
public MultitabBo(String mainCategory, String subCategory, String links) {
	super();
	this.mainCategory = mainCategory;
	this.subCategory = subCategory;
	this.links = links;
}
@Override
public String toString() {
	return "MultitabBo [mainCategory=" + mainCategory + ", subCategory=" + subCategory + ", links=" + links + "]";
}
public String getMainCategory() {
	return mainCategory;
}
public void setMainCategory(String mainCategory) {
	this.mainCategory = mainCategory;
}
public String getSubCategory() {
	return subCategory;
}
public void setSubCategory(String subCategory) {
	this.subCategory = subCategory;
}
public String getLinks() {
	return links;
}
public void setLinks(String links) {
	this.links = links;
}

}
