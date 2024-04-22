import two.CanEqual

beforeMethodCall { call ->
    if (call.methodAsString == 'equals') {
        lhsType = getType(call.objectExpression)
        rhsType = getType(call.arguments[0])
        if ([lhsType, rhsType].every{ type -> implementsInterfaceOrIsSubclassOf(type, classNodeFor(CanEqual)) }) {
            return
        }
        if (lhsType != rhsType) {
            addStaticTypeError("Invalid equality check: $lhsType.name != $rhsType.name", call)
            handled = true
        }
    }
}
