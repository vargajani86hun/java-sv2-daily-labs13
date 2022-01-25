package day01;

import java.util.*;
import java.util.stream.Collectors;

public class ClassNoteBook {
    private Map<Student, List<Integer>> classNotes = new TreeMap<>(Comparator.comparing(Student::getId));

    public void addStudent(Student student) {
        classNotes.put(student, new ArrayList<>());
    }

    public void addMark(int id, int mark) {
        for(Student s: classNotes.keySet()) {
            if (s.getId().equals(Integer.toString(id))) {
                classNotes.get(s).add(mark);
                return;
            }
        }
        throw new IllegalArgumentException("Student with ID: " + id + " can not found!");
    }
}
