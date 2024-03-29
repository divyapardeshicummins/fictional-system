package trail2;

//package hospitalmanagement;
import java.util.*;
public class Node{//Node

	String name;//name bloodgrp
	Node left;
	Node right;
	
	Queue<Blooddonation> donar = new LinkedList<>();
	Queue<Blooddonation> receiver = new LinkedList<>();

	Node (String name,Queue<Blooddonation> donar,Queue<Blooddonation> receiver){
		this.name=name;
		this.donar=donar;
		this.receiver=receiver;
		this.left=null;
		this.right=null;
	}
}