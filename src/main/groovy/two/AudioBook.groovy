package two

import groovy.transform.EqualsAndHashCode
import groovy.transform.TupleConstructor

@EqualsAndHashCode(callSuper = true, useCanEqual = false)
@TupleConstructor(callSuper = true, includeSuperProperties = true)
class AudioBook extends Book implements CanEqual {
    final int lengthInMinutes
    final int year

    boolean equals(other) {
        other in AudioBook ? _equals(other) : super.equals(other)
    }
}
