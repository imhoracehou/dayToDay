package com.horace.primeFaces.view;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

@ManagedBean(name = "userTreeNode")
@SessionScoped
public class UserTreeNode {
	private TreeNode root;
	private TreeNode selectedNode;

	public UserTreeNode() {
		// TreeNode
		this.root = new DefaultTreeNode("Root Node", null);
		TreeNode child = new DefaultTreeNode("Child Node", this.root);
		child.setParent(this.root);
		TreeNode descendent = new DefaultTreeNode("Descendent Node", child);
		descendent.setParent(child);
	}

	public void selectTreeNode() {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Selected", selectedNode.getData().toString());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	// --------------------------------------------------get and set

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	public TreeNode getSelectedNode() {
		return selectedNode;
	}

	public void setSelectedNode(TreeNode selectedNode) {
		this.selectedNode = selectedNode;
	}

}
