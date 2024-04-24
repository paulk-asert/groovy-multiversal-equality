import groovy.transform.TypeChecked
import two.AudioBook
import two.PrintedBook

@TypeChecked(extensions = 'canEquals.groovy')
def method() {
    var pBook = new PrintedBook("1984", "George Orwell", 328, 1949)
    var aBook = new AudioBook("1984", "George Orwell", 682, 2006)
    assert pBook == aBook
    assert aBook == pBook
    var reprint = new PrintedBook("1984", "George Orwell", 328, 1961)
    assert pBook != reprint
    assert aBook == reprint
}

method()
