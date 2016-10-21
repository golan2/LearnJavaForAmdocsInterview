// Exercise1.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <iostream>
#include <stdio.h>
#include <string>
#include <string.h>

using namespace std;


class TreeNode {
public:
	float prob;
	char letter;
	TreeNode * lSon;
	TreeNode * rSon;
	TreeNode * next;
	TreeNode(float prob1, char letter1);
};


TreeNode::TreeNode(float prob1, char letter1){
	prob=prob1;
	letter = letter1;
	lSon = NULL;
	rSon = NULL;
	next = NULL;
}

//----------------------------

class TreeNodeList {
	TreeNode *head;
public:
	TreeNodeList();
	bool IsEmpty();
	bool HasOneNode();
	void Insert(TreeNode *newNode);
	TreeNode * ExtractMin();
	void PrintTree();
	void PrintTreeRec(TreeNode *node,string code,float &sumBits);
};

TreeNodeList::TreeNodeList(){
	head = NULL;
}

bool TreeNodeList::IsEmpty(){
	bool res = false;
	if (head == NULL)
		res = true;
	return res;
}


bool TreeNodeList::HasOneNode(){
	bool res = false;
	if (head != NULL)
		if (head->next == NULL)
			res = true;
	return res;
}

void TreeNodeList::Insert(TreeNode *newNode){
	TreeNode *runner = head;
	if (runner == NULL)
		head = newNode;
	else {
		while (runner->next != NULL)
			runner = runner->next;
		runner->next = newNode;
	}
}

TreeNode * TreeNodeList::ExtractMin() {
	float minProb = 1;
	TreeNode *minNode = NULL;
	TreeNode *runner1 = head;
	TreeNode *runner2 = head;
	if (!IsEmpty()) {
		while (runner1 != NULL) {
			if (runner1->prob < minProb) {
				minProb = runner1->prob;
				minNode = runner1;
			}
			runner1 = runner1->next;
		}
		if (minNode==runner2)
			head = minNode->next;
		else 
			while (runner2->next != minNode)
				runner2=runner2->next;
			runner2->next = minNode->next;
	}
	return minNode;
}

void TreeNodeList::PrintTree() {
	float sumBits=0;
	PrintTreeRec(head,"",sumBits);
	cout << "Average bits per simbol - Compression rate:	" << sumBits  << endl;
	cout << "Compression ratio - " << 5/sumBits << endl;
}

void TreeNodeList::PrintTreeRec(TreeNode *node,string code,float &sumBits){
	if (node->lSon==NULL && node->rSon==NULL) {
		cout<<"Probablity is: "<< node->prob << "	Letter is: " << node->letter << "	Huffman code: "<< code << endl;
		sumBits = sumBits + code.length() * node->prob;
	}
	if (node->lSon !=NULL)
		PrintTreeRec(node->lSon, code+"0",sumBits);
	if (node->rSon !=NULL)
		PrintTreeRec(node->rSon, code+"1",sumBits);
		
}


//-------------------------------

TreeNodeList *MyList = new TreeNodeList();

void ParseFile (char *fileName){
	FILE * pFile;
	char ch;
	int simbolArr[27];
	int index;
	int probSum = 0;
	for (int i=0; i<27; i++)
		simbolArr[i]=0;
	pFile = fopen (fileName,"r");
	if (pFile != NULL)
	{
		while (feof( pFile ) == 0) {
			ch = fgetc( pFile );
			if ((int)ch == 32)	//space
				simbolArr[26]++;
			else {
				if (ch <= 'Z' && ch >= 'A')
				{
					index = ch - 'A';
					simbolArr[index] ++;
				}
				if (ch <= 'z' && ch >= 'a')
				{
					index = ch - 'a';
					simbolArr[index] ++;
				}
			}
		}
		for (int j=0; j<27; j++) {
			probSum = probSum + simbolArr[j];
		}
		float prob=0;
		for (int i=0; i<27; i++) {
			if (simbolArr[i] != 0) {
				prob = (float)simbolArr[i]/(float)probSum;
				if ( i == 26) {
					MyList->Insert(new TreeNode(prob,'_'));
				} else {
					char c = i + 'A';
					MyList->Insert(new TreeNode(prob,c));
				}
			}
		}
		
		fclose (pFile);
	}
}


void ReadInput(char *fileName) {
	FILE * pFile;
	char buffer[1024];
	char simbol[256];
	float prob;
	pFile = fopen (fileName,"r");
	if (pFile != NULL)
	{
		while ( fgets( buffer, 1024, pFile ) != NULL)
		{
			if ((buffer[0]<='Z' && buffer[0]>='A') || (buffer[0]<='z' && buffer[0]>='a'))
			{
				sscanf(buffer, "%s	%f",&simbol,&prob);
				//cout << "simbol:	" << simbol << endl;
				//printf("prob:	%f\n",prob);
				if ( strcmp(simbol,"space")==0 )
					MyList->Insert(new TreeNode(prob,'_'));
				else
					MyList->Insert(new TreeNode(prob,simbol[0]));
				memset(buffer,0,1024);
			}
		}
		fclose (pFile);
	}

}

void BuildTree() {
	while (!MyList->HasOneNode()) {
		TreeNode *Node1 = MyList->ExtractMin();
		TreeNode *Node2 = MyList->ExtractMin();
		TreeNode *Node3 = new TreeNode(Node1->prob + Node2->prob, '$');
		Node1->next = NULL;
		Node2->next = NULL;
		Node3->lSon = Node1;
		Node3->rSon = Node2;
		MyList->Insert(Node3);
	}
}

void Print() {
	MyList->PrintTree();
	
}

int main(int argc, char* argv[])
{	
	if (strstr(argv[1],"ENGLISH.TXT") )
		ParseFile(argv[1]);
	else
		ReadInput(argv[1]);
	BuildTree();
	Print();
	return 0;
}



