package trail2;

import java.util.*;

public class Bst {

	int don = 0;
	int rec = 0;
	Node root = null;
	Scanner sc = new Scanner(System.in);

	public void create() {
		ArrayList<String> bg = new ArrayList<>();
		bg.add("O-");
		bg.add("A");
		bg.add("B");
		bg.add("AB");
		bg.add("O+");
		bg.add("A+");
		// add blood group

		for (int i = 0; i < bg.size(); i++) {
			root=create(root, bg.get(i));
		}
	}

	public Node create(Node node1, String bloodgrp) {
	    if (node1 == null) {
	        Queue<Blooddonation> donar = new LinkedList<>();
	        Queue<Blooddonation> receiver = new LinkedList<>();

	        Node node = new Node(bloodgrp, donar, receiver);
	        return node;
	    }

	    if (bloodgrp.compareTo(node1.name) < 0) {
	        node1.left = create(node1.left, bloodgrp);
	    } else if (bloodgrp.compareTo(node1.name) > 0) {
	        node1.right = create(node1.right, bloodgrp);
	    }

	    return node1;
	}


	public void donatecreate() {
		System.out.println("Which is your bloodgroup");
		String bloodgrp = sc.next();

		Node curr = search(root, bloodgrp);

		System.out.println("Enter user all details");
		System.out.println("Enter Donar Name:");
		String DonarName = sc.next();
		System.out.println("Enter Donar Age:");
		int DonarAge = sc.nextInt();
		System.out.println("Enter Blood Group:");
		String BloodGroup = sc.next();

		Blooddonation d = new Blooddonation(DonarName, DonarAge, BloodGroup);

		if (curr.donar == null) {
			curr.donar = new LinkedList<>();
		}
		curr.donar.add(d);
		don++;
	}

	public void receivercreate() {
		System.out.println("Which is your bloodgroup");
		String bloodgrp = sc.next();

		Node curr = search(root, bloodgrp);

		System.out.println("Enter user all details");
		System.out.println("Enter receiver Name:");
		String recName = sc.next();
		System.out.println("Enter receiver Age:");
		int recAge = sc.nextInt();
		System.out.println("Enter Blood Group:");
		String BloodGroup = sc.next();

		Blooddonation r = new Blooddonation(recName, recAge, BloodGroup);
		if (curr.receiver == null) {
			curr.receiver = new LinkedList<>();
		}
		curr.receiver.add(r);
		rec++;
	}

	public Node search(Node root, String bloodgrp) {
		Node curr = root;
		// search code for bloodgrp
		if (root == null) {
			return null;
		}
		if (curr.name.equals(bloodgrp)) {
			return curr;
		}
		if (curr.name.compareTo(bloodgrp) > 0) {
			return search(curr.left, bloodgrp);
		}
		return search(curr.right, bloodgrp);

	}

	public void donate() {
		System.out.println("Enter bloodgroup");
		String bloodgroup = sc.next();
		Node curr = search(root, bloodgroup);
		if (curr == null) {
			System.out.println("Donar not found");
			return;
		}
		curr.donar.poll();
		Blooddonation rece = curr.receiver.poll();
		System.out.println("Receiver deatils: ");
		System.out.println("Receiver age is : " + rece.age);

	}

}
