package com.example.Vet.Hospital.transformer;

public abstract class Transformer<T, E> {
    public abstract T transform(E e);
}
