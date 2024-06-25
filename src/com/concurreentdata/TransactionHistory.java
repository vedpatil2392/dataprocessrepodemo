package com.concurreentdata;


import java.util.*;
import java.util.function.UnaryOperator;

public class TransactionHistory implements List<Transaction> 
{
    private final List<Transaction> transactions = new ArrayList<>();

    @Override
    public synchronized boolean add(Transaction transaction) {
        return transactions.add(transaction);
    }

    @Override
    public synchronized Transaction get(int index) {
        return transactions.get(index);
    }

    @Override
    public synchronized int size() {
        return transactions.size();
    }

    @Override
    public synchronized Transaction remove(int index) {
        return transactions.remove(index);
    }

    @Override
    public synchronized boolean isEmpty() {
        return transactions.isEmpty();
    }

    @Override
    public synchronized Iterator<Transaction> iterator() {
        // Return a snapshot iterator to avoid ConcurrentModificationException
        return new ArrayList<>(transactions).iterator();
    }

    @Override
    public synchronized void clear() {
        transactions.clear();
    }

    @Override
    public synchronized boolean contains(Object o) {
        return transactions.contains(o);
    }

    @Override
    public synchronized Object[] toArray() {
        return transactions.toArray();
    }

    @Override
    public synchronized <T> T[] toArray(T[] a) {
        return transactions.toArray(a);
    }

    @Override
    public synchronized boolean remove(Object o) {
        return transactions.remove(o);
    }

    @Override
    public synchronized boolean containsAll(Collection<?> c) {
        return transactions.containsAll(c);
    }

    @Override
    public synchronized boolean addAll(Collection<? extends Transaction> c) {
        return transactions.addAll(c);
    }

    @Override
    public synchronized boolean addAll(int index, Collection<? extends Transaction> c) {
        return transactions.addAll(index, c);
    }

    @Override
    public synchronized boolean removeAll(Collection<?> c) {
        return transactions.removeAll(c);
    }

    @Override
    public synchronized boolean retainAll(Collection<?> c) {
        return transactions.retainAll(c);
    }

    @Override
    public synchronized Transaction set(int index, Transaction element) {
        return transactions.set(index, element);
    }

    @Override
    public synchronized void add(int index, Transaction element) {
        transactions.add(index, element);
    }

    @Override
    public synchronized int indexOf(Object o) {
        return transactions.indexOf(o);
    }

    @Override
    public synchronized int lastIndexOf(Object o) {
        return transactions.lastIndexOf(o);
    }

    @Override
    public synchronized ListIterator<Transaction> listIterator() {
        return new ArrayList<>(transactions).listIterator();
    }

    @Override
    public synchronized ListIterator<Transaction> listIterator(int index) {
        return new ArrayList<>(transactions).listIterator(index);
    }

    @Override
    public synchronized List<Transaction> subList(int fromIndex, int toIndex) {
        return new ArrayList<>(transactions.subList(fromIndex, toIndex));
    }

    @Override
    public synchronized void replaceAll(UnaryOperator<Transaction> operator) {
        transactions.replaceAll(operator);
    }

    @Override
    public synchronized void sort(Comparator<? super Transaction> c) {
        transactions.sort(c);
    }

    @Override
    public synchronized Spliterator<Transaction> spliterator() {
        return new ArrayList<>(transactions).spliterator();
    }
}
