/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inBeta;

/**
 *
 * @author Robert
 */
public class GetPath {
    public GetPath(){
        System.out.println(this.getClass().getResource("/assets/files/csv.csv").getPath());
    }
    public static void main(String[] args){
        GetPath GP = new GetPath();
    }
}
