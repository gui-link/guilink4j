package com.bitwormhole.guilink.events;

import java.util.ArrayList;
import java.util.List;

public final class EventListenerChain<EVENT, LISTENER> {

    private EventListenerChain<EVENT, LISTENER> next;
    private LISTENER listener;

    public static interface DispatcherFunction<EVENT, LISTENER> {
        void dispatch(EVENT e, LISTENER li);
    }

    public static <EVENT, LISTENER> void dispatchEvent(
            EventListenerChain<EVENT, LISTENER> chain, EVENT event, DispatcherFunction<EVENT, LISTENER> fn) {

        if (chain == null || event == null || fn == null) {
            return;
        }
        EventListenerChain<EVENT, LISTENER> p = chain;
        for (; p != null; p = p.next) {
            LISTENER li = p.listener;
            if (li == null) {
                continue;
            }
            fn.dispatch(event, li);
        }
    }

    public static <EVENT, LISTENER> EventListenerChain<EVENT, LISTENER> removeListener(
            EventListenerChain<EVENT, LISTENER> chain, LISTENER li) {
        if (li == null || chain == null) {
            return chain;
        }
        int count = 0;
        EventListenerChain<EVENT, LISTENER> p = chain;
        for (; p != null; p = p.next) {
            if (li.equals(p.listener)) {
                p.listener = null;
                count++;
            }
        }
        if (count > 0) {
            chain = trim(chain);
        }
        return chain;
    }

    public static <EVENT, LISTENER> EventListenerChain<EVENT, LISTENER> trim(
            EventListenerChain<EVENT, LISTENER> chain) {

        // 先检查是否有空的 listener
        EventListenerChain<EVENT, LISTENER> p = chain;
        boolean has_null = false;
        for (; p != null; p = p.next) {
            if (p.listener == null) {
                has_null = true;
                break; // 不需要完全遍历
            }
        }
        if (!has_null) {
            return chain;
        }

        // 把需要保留的 node 暂时存入 tmp
        List<EventListenerChain<EVENT, LISTENER>> tmp = new ArrayList<>();
        for (; p != null; p = p.next) {
            if (p.listener != null) {
                tmp.add(p);
            }
        }

        // 利用回收的节点重组 chain
        final int count = tmp.size();
        if (count <= 0) {
            return null;
        }
        EventListenerChain<EVENT, LISTENER> n1, n2;
        for (int i = count - 1; i > 0; i--) {
            n1 = tmp.get(i - 1);
            n2 = tmp.get(i);
            n1.next = n2;
        }

        // 最后,处理 chain 的头&尾
        n1 = tmp.get(0);
        n2 = tmp.get(count - 1);
        n2.next = null;
        return n1;
    }

    public static <EVENT, LISTENER> EventListenerChain<EVENT, LISTENER> addListener(
            EventListenerChain<EVENT, LISTENER> chain, LISTENER li) {

        if (li == null) {
            return chain;
        }

        if (containsListener(chain, li)) {
            return chain;
        }

        EventListenerChain<EVENT, LISTENER> p = new EventListenerChain<>();
        p.next = chain;
        p.listener = li;
        return p;
    }

    public static <EVENT, LISTENER> boolean containsListener(
            EventListenerChain<EVENT, LISTENER> chain, LISTENER li) {
        if (li == null) {
            return false;
        }
        EventListenerChain<EVENT, LISTENER> p = chain;
        for (; p != null; p = p.next) {

            if (li.equals(p.listener)) {
                return true;
            }
        }
        return false;
    }

    private EventListenerChain() {
    }
}
