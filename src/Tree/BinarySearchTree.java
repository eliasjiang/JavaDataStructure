package Tree;

import java.nio.BufferUnderflowException;

public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> {
    private BinaryNode<AnyType> root;

    public BinarySearchTree(){
        root = null;
    }

    public void makeEmpty(){
        root = null;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public boolean contains(AnyType x){
        return contains(x,root);
    }

    public AnyType findMin(){
        if(isEmpty()) throw new BufferUnderflowException();
        return findMin(root).element;
    }

    public AnyType findMax(){
        if(isEmpty()) throw new BufferUnderflowException();
        return findMax(root).element;
    }

    public void insert(AnyType x){
        root = insert(x,root);
    }

    public void remove(AnyType x){
        root = remove(x,root);
    }

    public void printTree(){}


    private boolean contains(AnyType x,BinaryNode<AnyType> t){
        if(t==null) return false;

        int compareResult = x.compareTo(t.element);

        if(compareResult<0) return contains(x,t.left);
        else if(compareResult >0) return contains(x,t.right);
        else return true;
    }

    private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t){
        if(t == null) return null;
        else if(t.left == null) return t;
        else return findMin(t.left);
    }

    private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t){
        if(t == null) return null;
        else if(t.right==null) return t;
        else return findMax(t.right);
    }

    private BinaryNode<AnyType> insert(AnyType x,BinaryNode<AnyType> t){
        if(t==null) return new BinaryNode<>(x,null,null);

        int compareResult = x.compareTo(t.element);

        if(compareResult<0) t.left = insert(x,t.left);
        else if(compareResult>0) t.right = insert(x,t.right);
        else ;
        return t;

    }

    private BinaryNode<AnyType> remove(AnyType x,BinaryNode<AnyType> t){
        if(t == null) return t;

        int compareResult = x.compareTo(t.element);

        if(compareResult < 0) t.left = remove(x,t.left);
        else if(compareResult>0) t.right = remove(x,t.right);
        else if(t.left!=null&&t.right!=null){
            t.element = findMin(t.right).element;
            t.right = remove(t.element,t.right);
        }else{
            t = (t.left!=null)?t.left:t.right;
        }

        return t;

    }

    private void printTree(BinaryNode<AnyType> t){

    }




    private static class BinaryNode<AnyType>{
        AnyType element;
        BinaryNode<AnyType> left;
        BinaryNode<AnyType> right;
        BinaryNode(AnyType theElement){this(theElement,null,null);}
        BinaryNode(AnyType theElement,BinaryNode<AnyType> lt,BinaryNode<AnyType> rt){
            element = theElement;left = lt;right = rt;
        }
    }
}
