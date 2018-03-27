package edu.ung.phys2211;

public enum BGImageType {
	
	TREE(0, "figs/tree.png"), BIRD(1, "figs/bird.gif");
	
	private int id;
	private String imgName;
	
	BGImageType(int id, String imgName) {
		this.id = id;
		this.imgName = imgName;
	}

	public int getId() {
		return id;
	}

	public String getImgName() {
		return imgName;
	}

}
