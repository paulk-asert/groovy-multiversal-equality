import one.AudioBook
import one.PrintedBook
import org.apache.groovy.typecheckers.CheckingVisitor
import org.codehaus.groovy.ast.expr.BinaryExpression
import org.codehaus.groovy.syntax.Types

beforeMethodCall { call ->
    if (call.methodAsString == 'equals') {
        lhsType = getType(call.objectExpression)
        rhsType = getType(call.arguments[0])
        if (lhsType != rhsType &&
            lhsType != classNodeFor(PrintedBook) &&
            rhsType != classNodeFor(AudioBook)) {
            addStaticTypeError("Invalid equality check: $lhsType.name != $rhsType.name", call)
            handled = true
        }
    }
}

afterVisitMethod { method ->
    method.code.visit(new CheckingVisitor() {
        @Override
        void visitBinaryExpression(BinaryExpression be) {
            if (be.operation.type !in [Types.COMPARE_EQUAL, Types.COMPARE_NOT_EQUAL]) {
                return
            }
            lhsType = getType(be.leftExpression)
            rhsType = getType(be.rightExpression)
            if (lhsType != rhsType &&
                lhsType != classNodeFor(PrintedBook) &&
                rhsType != classNodeFor(AudioBook)) {
                addStaticTypeError("Invalid equality check: $lhsType.name != $rhsType.name", be)
                handled = true
            }
        }
    })
/*
    checkingVisitor(method.code, binaryExpression: { BinaryExpression be ->
        if (be.operation.type !in [Types.COMPARE_EQUAL, Types.COMPARE_NOT_EQUAL]) {
            return
        }
        lhsType = getType(be.leftExpression)
        rhsType = getType(be.rightExpression)
        if (lhsType != rhsType &&
            lhsType != classNodeFor(PrintedBook) &&
            rhsType != classNodeFor(AudioBook)) {
            addStaticTypeError("Invalid equality check: $lhsType.simpleName != $rhsType.name", be)
            handled = true
        }
    })
*/
}
