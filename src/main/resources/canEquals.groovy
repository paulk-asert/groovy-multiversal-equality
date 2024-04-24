import org.apache.groovy.typecheckers.CheckingVisitor
import org.codehaus.groovy.ast.expr.BinaryExpression
import org.codehaus.groovy.syntax.Types
import two.CanEqual

/*
beforeMethodCall { call ->
    if (call.methodAsString == 'equals') {
        lhsType = getType(call.objectExpression)
        rhsType = getType(call.arguments[0])
        if ([lhsType, rhsType].every { type ->
            implementsInterfaceOrIsSubclassOf(type, classNodeFor(CanEqual))
        }) {
            return
        }
        if (lhsType != rhsType) {
            addStaticTypeError("Invalid equality check: $lhsType.name != $rhsType.name", call)
            handled = true
        }
    }
}
*/
afterVisitMethod { method ->
    method.code.visit(new CheckingVisitor() {
        @Override
        void visitBinaryExpression(BinaryExpression be) {
            if (be.operation.type !in [Types.COMPARE_EQUAL, Types.COMPARE_NOT_EQUAL]) {
                return
            }
            var lhsType = getType(be.leftExpression)
            var rhsType = getType(be.rightExpression)
            if ([lhsType, rhsType].every { type ->
                implementsInterfaceOrIsSubclassOf(type, classNodeFor(CanEqual))
            }) {
                return
            }
            if (lhsType != rhsType) {
                addStaticTypeError("Invalid equality check: $lhsType.name != $rhsType.name", be)
                handled = true
            }
        }
    })
}
