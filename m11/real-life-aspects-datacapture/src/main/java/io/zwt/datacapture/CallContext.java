package io.zwt.datacapture;

import org.aspectj.lang.JoinPoint;

import java.util.ArrayList;
import java.util.List;

class CallContext {

    private List<Call> calls = new ArrayList<>();

    private Throwable firstFailure;

    private int depth = 0;

    public void before(JoinPoint joinPoint) {
        calls.add(new Call(joinPoint, this.depth++));
    }

    public void afterReturning(Object result) {
        calls.get(calls.size() - 1).setResult(result.toString());
        endCall();
    }

    private void endCall() {
        this.depth--;
        if (depth == 0) {
            calls.clear();
        }
    }

    public void afterThrowing(Throwable ex) {
        if (this.firstFailure == null) {
            this.firstFailure = ex;
        }
        log(ex);
        endCall();
    }

    private void log(Throwable ex) {
        for (Call c : calls) {
            String builder = "    ".repeat(Math.max(0, c.getDepth())) +
                c.toString();
            System.out.println(builder);
        }
        System.out.println("Call resulted in exception");
        ex.printStackTrace();
        if (firstFailure != null && firstFailure != ex) {
            System.out
                .println("First failure detected other than exception thrown: "
                    + firstFailure.getMessage());
            firstFailure.printStackTrace();
        }
    }

}
