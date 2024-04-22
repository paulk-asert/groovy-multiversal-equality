import groovy.transform.TypeChecked
import one.AudioBook
import one.PrintedBook

@TypeChecked(extensions = 'strictEqualsButRelaxedForPrintedBook.groovy')
def method() {
    var pBook = new PrintedBook(328, "1984", "George Orwell", 1961)
    var aBook = new AudioBook(682, "1984", "George Orwell", 2006)
//    assert pBook.equals(aBook)
    assert pBook == aBook
    assert aBook != pBook // [Static type checking] - Invalid equality check: AudioBook != PrintedBook
//    assert aBook.equals(pBook) // [Static type checking] - Invalid equality check: AudioBook != PrintedBook
//    assert 3 != 'foo' // [Static type checking] - Invalid equality check: int != java.lang.String
//    assert 3 == 3f // [Static type checking] - Invalid equality check: int != float
//    assert 3.equals('foo') // [Static type checking] - Invalid equality check: int != java.lang.String
}

method()
