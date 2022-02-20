package day01;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ClassNoteBookTest {

    @Test
    void testStudent() {
        ClassNoteBook classNoteBook = new ClassNoteBook();
        Student s = new Student("111111", "Jhon");
        classNoteBook.addStudent(s);

        assertTrue(classNoteBook.getClassNotes().containsKey(s));
        assertEquals(0, classNoteBook.getClassNotes().get(s).size());

    }

    @Test
    void testAddStudentInOrder() {
        ClassNoteBook classNoteBook = new ClassNoteBook();
        Student s1 = new Student("3", "Jhon");
        Student s2 = new Student("1", "Jack");
        Student s3 = new Student("2", "Jane");
        classNoteBook.addStudent(s1);
        classNoteBook.addStudent(s2);
        classNoteBook.addStudent(s3);

        assertEquals(List.of(s2, s3, s1), new ArrayList<>(classNoteBook.getClassNotes().keySet()));

        int i = 1;
        for (Map.Entry<Student, List<Integer>> actual: classNoteBook.getClassNotes().entrySet()) {
            assertEquals(Integer.toString(i), actual.getKey().getId());
            i++;
        }
    }

}