/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tarea.programada1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * A class that performs operations on student names uploaded from a file txt.
 * No pude realizar el punto C
 * @author chava
 */

public class TareaProgramada1 {

    public static void main(String[] args) {
        /**
         * Upload names from the file
         */
        HashSet<String> names = loadNamesFromFile("programacion.txt");
       
        showNames(names);
        
        repeatedNames(names);
        
        sortList(names);
        
        removeStudent(names, "FALLAS GONZALEZ WILLIAM");
        
        EditStudent(names, "segura reyes bryan niky", "Chavarria HERNANDEZ "
                + "LEANDRO");
        
        searchStudent(names, "rodriguez vargas luis fernando");
        
        showNames(names);
    
    }
    
    /**
     * It uploads student names from a file and stores them in a hanshsent
     * @param fileName
     * @return 
     */
    public static HashSet<String> loadNamesFromFile(String fileName) {
        HashSet<String> names = new HashSet<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split("\t"); 
                String fullName = fields[4].trim().toLowerCase(); 
                if (!names.add(fullName)) {
                    System.out.println("Nombre completo repetido: " + fullName);
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return names;
    }
/**
 * Displays student names stored in a set.
 * @param names 
 */
    public static void showNames(HashSet<String> names) {
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println("");
        
        
    }

  public static void repeatedNames(HashSet<String> names) {
      
        
         HashSet<String> duplicateNames = findDuplicateName(names);
        
        if (!duplicateNames.isEmpty()) {
            System.out.println("Nombres completos repetidos:");
            for (String name : duplicateNames) {
                System.out.println(name);
            }
        
        }
    }
 /**
  * Sort the list of student names and display it in alphabetical order.
  * @param names 
  */
    public static void sortList(HashSet<String> names) {
        List<String> orderedList = new ArrayList<>(names);
        Collections.sort(orderedList);
        System.out.println("Lista ordenada:");
        for (String name : orderedList) {
            System.out.println(name);
        }
    }
    /**
     * Find the names of duplicate students in the set.
     * @param names
     * @return 
     */
    public static HashSet<String> findDuplicateName(HashSet<String> names) {
        HashSet<String> repeatedName = new HashSet<>();
        HashSet<String> seenNames = new HashSet<>();
        for (String name : names) {
            if (!seenNames.add(name)) {
                repeatedName.add(name);
            }
        }
        return repeatedName;
    }
    public static void removeStudent(HashSet<String> names, String student) {
        names.remove(student);
        System.out.println("Estudiante \"" + student + "\" removido"
                + " exitosamente.");
    }

    public static void EditStudent(HashSet<String> names, 
            String existingStudent, String newName) {
        if (names.contains(existingStudent)) {
            names.remove(existingStudent);
            names.add(newName);
            System.out.println("Estudiante \"" + existingStudent 
                    + "\" editado a \"" + newName + "\" exitosamente.");
        } else {
            System.out.println("No se encontró el estudiante \"" 
                    + existingStudent + "\".");
        }
    }

    public static void searchStudent(HashSet<String> names, String Student) {
        if (names.contains(Student)) {
            System.out.println("Estudiante \"" + Student + "\" encontrado.");
        } else {
            System.out.println("No se encontró el estudiante \"" 
                    + Student + "\".");
        }
    }
}
    

