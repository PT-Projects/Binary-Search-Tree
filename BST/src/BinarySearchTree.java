import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

/**
 * A class to represent a binary search tree.
 * @author Koffman and Wolfgang
 */
public class BinarySearchTree<E extends Comparable<E>>
         extends BinaryTree<E> {
    
    //Methods
    /*<listing chapter="6" number="3">*/
    /**
     * Starter method find.
     * @pre The target object must implement
     *      the Comparable interface.
     * @param target The Comparable object being sought
     * @return The object, if found, otherwise null
     */
    
    public E find(E target) {
        return find(root, target);
    }

    /**
     * Recursive find method.
     * @param localRoot The local subtree�s root
     * @param target The object being sought
     * @return The object, if found, otherwise null
     */
    private E find(Node<E> localRoot, E target) {

        if (localRoot.data.equals(target)){
            return localRoot.data;
        }
        else{
            try{
                E left = find(localRoot.left, target);
                if (left.equals(target)){
                    return left;
                }
            }
            catch (NullPointerException e){}
            try{
                E right = find(localRoot.right, target);
                if (right.equals(target)){
                    return right;
                }
            }
            catch (NullPointerException e){}
        }

        return null;

    }

    private Node<E> findNode(Node<E> localRoot, E target){

        if (localRoot.data.equals(target)){
            return localRoot;
        }
        else{
            try{
                E left = find(localRoot.left, target);
                if (left.equals(target)){
                    return localRoot.left;
                }
            }
            catch (NullPointerException e){}
            try{
                E right = find(localRoot.right, target);
                if (right.equals(target)){
                    return localRoot.right;
                }
            }
            catch (NullPointerException e){}
        }

        return null;
    }
   
    /**
     * Starter method add.
     * @pre The object to insert must implement the
     *      Comparable interface.
     * @param item The object being inserted
     * @return true if the object is inserted, false
     *         if the object already exists in the tree
     */
    public boolean add(E item) {
        if (root == null){
            root = new Node<>(item);
            return true;
        }
        else {
            add(root, item);
            return true;
        }
    }

    /**
     * Recursive add method.
     * @post The data field addReturn is set true if the item is added to
     *       the tree, false if the item is already in the tree.
     * @param localRoot The local root of the subtree
     * @param item The object to be inserted
     * @return The new local root that now contains the
     *         inserted item
     */
    private void add(Node<E> localRoot, E item) {

        if (item.compareTo(localRoot.data) == 0){
            return;
        }
        else if (item.compareTo(localRoot.data) < 0 && localRoot.left == null){
            localRoot.left = new Node<>(item);
            return;
        }
        else if (item.compareTo(localRoot.data) > 0 && localRoot.right == null){
            localRoot.right = new Node<>(item);
            return;
        }
        else if (item.compareTo(localRoot.data) < 0){
            add(localRoot.left, item);
            return;
        }
        else{
            add(localRoot.right, item);
            return;
        }

    }
    
    /**
     * Starter method delete.
     * @post The object is not in the tree.
     * @param target The object to be deleted
     * @throws ClassCastException if target does not implement
     *         Comparable
     */
    public void delete(E target) {
        root = delete(root, target);
    }

    /**
     * Recursive delete method.
     * @post The item is not in the tree;
     *       deleteReturn is equal to the deleted item
     *       as it was stored in the tree or null
     *       if the item was not found.
     * @param localRoot The root of the current subtree
     * @param item The item to be deleted
     * @return The modified local root that does not contain
     *         the item
     */
    private Node<E> delete(Node<E> localRoot, E item) {

        if (localRoot == null){
            return null;
        }
        else if (item.compareTo(localRoot.data) < 0){
            localRoot.left = delete(localRoot.left, item);
        }
        else if (item.compareTo(localRoot.data) > 0){
            localRoot.right = delete(localRoot.right, item);
            return localRoot;
        }
        else{
            if (localRoot.left == null && localRoot.right == null){
                return null;
            }
            else if (localRoot.left == null){
                return localRoot.right;
            }
            else if (localRoot.right == null){
                return localRoot.left;
            }
            else {
                if (localRoot.left.right == null){
                    localRoot.left.right = localRoot.right;
                    return localRoot.left;
                }
                else{
                    E data = findLargestChild(localRoot.left);
                    delete(data);
                    localRoot.data = data;
                    return localRoot;
                }
            }
        }
        return localRoot;

    }
    
    /**
     * Find the node that is the
     * inorder predecessor and replace it
     * with its left child (if any).
     * @post The inorder predecessor is removed from the tree.
     * @param parent The parent of possible inorder
     *        predecessor (ip)
     * @return The data in the ip
     */
    private E findLargestChild(Node<E> parent) {
       return null; // temporary
    }
}

