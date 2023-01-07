package com.aks.learnings.trees.quad;

public class QuadTreeTest {

	public static final BoundPoints UL = new BoundPoints(0, 0);
	public static final BoundPoints UR = new BoundPoints(0, 1);
	public static final BoundPoints BL = new BoundPoints(1, 0);
	public static final BoundPoints BR = new BoundPoints(1, 1);

	public static void main(
	    String[] args) {

		try {

			Integer[][] arr = {
			    { 1, 2, 3, 4 },
			    { 5, 6, 7, 8 },
			    { 5, 6, 7, 8 },
			    { 5, 6, 7, 8 }
			};

			constructQuadTree(arr);
			/*
			 * 
			 * |----------|----------|
			 * |  0,0 0,1 | 0,2 0,3  |
			 * |  1,0 1,1 | 1,2 1,3  |
			 * |----------|----------|
			 * |  2,0 2,1 | 2,2 2,3  | 
			 * |  3,0 3,1 | 3,2 3,3  |
			 * |----------|----------|
			 * 
			 */

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	private static void constructQuadTree(
	    Integer[][] arr) {

		QuadNode root = null;

		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr[i].length; j++) {

				QuadNode qn = new QuadNode(
				    arr[i][j],
				    i,
				    j,
				    null,
				    null,
				    null,
				    null);

				root = insertQN(root, qn);

			}
		}
	}

	private static QuadNode insertQN(
	    QuadNode root,
	    QuadNode qn) {

		if (root == null) {

			root = qn;
		} else {

			/*
			 * The root already exists.
			 * Following scenarios are possible:
			 * 1 - The root is a single leaf node
			 * 2 - The root is unbalanced tree, with the node insertion in sub-tree
			 * 3 - the root is balanced tree, with the node insertion in sub-tree
			 *
			 * Follow up questions:
			 * 1) Should we create all nodes in the tree at sibling level,
			 *     whenever a node insertion increases height?
			 * 2) Is this why quad trees are inefficient for memory?
			 * 3) Could there be optimizations on storage level?
			 * 4) How to define values of a node at intermediate level?
			 */
		}

		return root;
	}

	public static class BoundPoints {

		Integer x;
		Integer y;

		public BoundPoints(
		    int i,
		    int j) {

			this.x = i;
			this.y = j;
		}

		public Integer getX() {

			return this.x;
		}

		public Integer getY() {

			return this.y;
		}
	}

	public static class QuadNode {

		Integer value;
		Integer x;
		Integer y;

		private QuadNode ul;
		private QuadNode ur;
		private QuadNode bl;
		private QuadNode br;

		public QuadNode() {

			value = -1;
			x     = -1;
			y     = -1;
			ul    = null;
			ur    = null;
			bl    = null;
			br    = null;
		}

		public QuadNode(
		    int n,
		    int i,
		    int j,
		    QuadNode ul,
		    QuadNode ur,
		    QuadNode bl,
		    QuadNode br) {

			this.value = n;
			this.x     = i;
			this.y     = j;
			this.ul    = ul;
			this.ur    = ur;
			this.bl    = bl;
			this.br    = br;
		}

		public Integer getN() {

			return value;
		}

		public void setN(
		    Integer n) {

			this.value = n;
		}

		public QuadNode getUl() {

			return ul;
		}

		public void setUl(
		    QuadNode ul) {

			this.ul = ul;
		}

		public QuadNode getUr() {

			return ur;
		}

		public void setUr(
		    QuadNode ur) {

			this.ur = ur;
		}

		public QuadNode getBl() {

			return bl;
		}

		public void setBl(
		    QuadNode bl) {

			this.bl = bl;
		}

		public QuadNode getBr() {

			return br;
		}

		public void setBr(
		    QuadNode br) {

			this.br = br;
		}
	}
}
