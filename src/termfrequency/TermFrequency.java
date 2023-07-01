/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package termfrequency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.Double;

/**
 *
 * @author Kamal_2
 */
public class TermFrequency {

    /**
     * @param args the command line arguments
     */
    
    public void printList(List<String> doc) {
        for(String word: doc) {
            System.out.print(word + " ");
        }
        
        System.out.println("\n");
    }
    
    public void printListOfLists(List<List<String>> docs) {
        for(List<String> doc : docs){
            for(String word : doc) {
                System.out.print(word + " ");
            }
            System.out.println("\n");
        }
    }
    
    public void printListOfArrayLists(ArrayList<ArrayList<String>> docs) {
        for(ArrayList<String> doc : docs){
            for(String word : doc) {
                System.out.print(word + " ");
            }
            System.out.println("\n");
        }
    }
    
    public double idf(List<List<String>> docs, String term){
        int count = 0;
        for(List<String> doc : docs){
            if(doc.contains(term)) {
                count++;
            }
        }
//        System.out.println(term + " count docs = " + count);
        double result = Math.log10(docs.size() * 1.0 / count);
//        System.out.println(term + " idf = " + result);
        return result;
//        Math.l
    }
    
    public int tf(List<String> doc, String term) {
        int count = 0; 
        for(String str: doc){
            if(str == term){
                count++;
            }
        }
        
//        System.out.println(term + " tf = " + count);
        return count;
    }
    
    public double tf_idf(int tf, double idf) {
        return tf * idf;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        TermFrequency freq = new TermFrequency();
        List<String> doc1 = Arrays.asList("the", "sky", "is", "blue");
        List<String> doc2 = Arrays.asList("the", "sun", "is", "bright");
        List<String> doc3 = Arrays.asList("the", "sun", "in", "the", "sky", "is", "bright");
        
        List<List<String>> corpus = Arrays.asList(doc1, doc2, doc3);
        freq.printList(doc1);
        freq.printList(doc2);
        System.out.println("\nDocument Collection:");
        freq.printListOfLists(corpus);
        
        
//        documentVector.add(doc3);
//        doc1.add("hell0");
        ArrayList<String> uniqueWords = new ArrayList<>();
        List<String> zeros = new ArrayList<>();
        for(List<String> doc : corpus){
            for(String word : doc) {
                if(!uniqueWords.contains(word)) {
                    uniqueWords.add(word);
                    zeros.add("0");
                }
            }
        }
        System.out.println("\n\n" + uniqueWords);
        
//        List<List<String>> documentVector = Arrays.asList(uniqueWords, zeros, zeros, zeros);
        ArrayList<ArrayList<Double>> documentVector = new ArrayList<ArrayList<Double>>();
        
//        ArrayList<String> temp = new ArrayList<>();
//        documentVector.add(uniqueWords);
        
//        The following code is effective but hectic
//        for(int i = 0; i < corpus.size(); i++) {
//            System.out.println("i = " + i);
//            ArrayList<String> temp1 = new ArrayList<>();
//            documentVector.add(temp1);
//            System.out.println("size : " + documentVector.size());
//            
//            for(int k = 0; k < documentVector.get(i).size(); k++) {
//                documentVector.get(i + 1).add("0");
//            }
//            for(int j = 0; j < corpus.get(i).size(); j++) {
//                System.out.println("j = " + j);
//                if(documentVector.get(0).contains(corpus.get(i).get(j))) {
//                    documentVector.get(i + 1).set(documentVector.get(0).indexOf(corpus.get(i).get(j)), "" + (Integer.parseInt(documentVector.get(i + 1).get(documentVector.get(0).indexOf(corpus.get(i).get(j)))) + 1));
//                } else {
//                    documentVector.get(0).add(corpus.get(i).get(j));
//                    documentVector.get(i + 1).add("" + 0);
//                    documentVector.get(i + 1).set(documentVector.get(0).indexOf(corpus.get(i).get(j)), "" + 1);
//                }
//            }
//        }


//        for(List<String> doc : corpus){
            ArrayList<Double> temp = new ArrayList<Double>();
            
            for(String word : uniqueWords) {
                temp.add(freq.tf_idf(freq.tf(doc1, word), freq.idf(corpus, word)));
            }
            documentVector.add(temp);
            System.out.println(temp);
//        }
//        System.out.println(Math.log(2.0/3.0));
        
//        freq.printListOfArrayLists(documentVector);
    }
    
}
