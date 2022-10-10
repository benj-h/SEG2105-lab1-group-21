package com.group_21.seg2105_lab1;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.RhinoException;
import org.mozilla.javascript.Scriptable;

public class Evaluator {
    private String expression;
    private static double result;
    private Context rhino;
    private Scriptable scope;

    public static double evaluate_expression(String expression) {
        String js_expression = "function evaluate(arithmetic){  return eval(arithmetic)    ;} ";
        Object[] function_params = new Object[]{expression};
        Context rhino = Context.enter();
        rhino.setOptimizationLevel(-1);
        if (MainActivity.get_state() == MainActivity.State.EVALUATE) {
            try {
                Scriptable scope = rhino.initStandardObjects();
                rhino.evaluateString(scope, js_expression, "JavaScript", 1,null);
                Function function = (Function)scope.get("evaluate", scope);
                result = (Double)function.call(rhino, scope, scope, function_params);
            }
            catch (RhinoException e) {
                result = Double.NaN;
            }
            finally {
                Context.exit();
            }
        }
        return result;
    }
}
