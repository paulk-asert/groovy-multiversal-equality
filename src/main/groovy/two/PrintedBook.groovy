package two

import groovy.transform.EqualsAndHashCode
import groovy.transform.TupleConstructor

@EqualsAndHashCode(callSuper = true, useCanEqual = false)
@TupleConstructor(callSuper = true, includeSuperProperties = true)
class PrintedBook extends Book implements CanEqual {
    final int pages
    final int year

    boolean equals(other) {
        other in PrintedBook ? _equals(other) : super.equals(other)
    }
}
