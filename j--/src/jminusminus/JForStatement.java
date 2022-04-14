package jminusminus;

import java.util.ArrayList;

public class JForStatement extends JStatement{

    /** The for loop initializer for the loop declaration commonly follows format: int i=0 */
    JForInit forInit;

    /** The for loop update for the loop declaration commonly follows format: i++ */
    ArrayList<JStatement> forUpdate;

    /** The body of the for loop statement */
    JStatement body;

    /** The expression of the for loop declaration commonly follows format: i < MAX_LOOP_COUNT */
    JExpression expression;

    public JForStatement(int line,
            JForInit forInit,
            JExpression expression, 
            ArrayList<JStatement> forUpdate, 
            JStatement body) {
        super(line);
        this.forInit=forInit;
        this.forUpdate=forUpdate;
        this.body= body;
        this.expression=expression;
    }

    public JWhileStatement analyze(Context context) {
        throw new UnsupportedOperationException("NOT IMPLEMENTED");
    }

    public void codegen(CLEmitter output) {
        throw new UnsupportedOperationException("NOT IMPLEMENTED");
    }

    /**
     * {@inheritDoc}
     */

    public void writeToStdOut(PrettyPrinter p) {
        p.printf("<JForStatement line=\"%d\">\n", line());

        if (forInit != null) {
            p.indentRight();
            p.println("<JForInit>");

            // Get what type of forInit it is
            if (forInit.isStatementExpression) {
                for (JStatement statement : forInit.statements) {
                    p.indentRight();
                    statement.writeToStdOut(p);
                    p.indentLeft();
                }
            } else {
                for (JVariableDeclarator variable : forInit.variableDeclarators) {
                    p.indentRight();
                    variable.writeToStdOut(p);
                    p.indentLeft();
                }
            }

            p.println("</JForInit>");
            p.indentLeft();
        }

        if (expression != null) {
            p.indentRight();
            p.println("<JForExpression>");
            p.indentRight();
            expression.writeToStdOut(p);
            p.indentLeft();
            p.println("</JForExpression>");
            p.indentLeft();
        }

        if (forUpdate != null) {
            p.indentRight();
            p.println("<JForUpdate>");
            p.indentRight();
            for(JStatement statement : forUpdate){
                p.indentRight();
                statement.writeToStdOut(p);
                p.indentLeft();
            }
            p.indentLeft();
            p.println("</JForUpdate>");
            p.indentLeft();
        }

        p.printf("<Body>\n");
        p.indentRight();
        body.writeToStdOut(p);
        p.indentLeft();
        p.printf("</Body>\n");
    }
}
