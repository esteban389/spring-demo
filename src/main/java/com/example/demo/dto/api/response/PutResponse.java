package com.example.demo.dto.api.response;

public sealed interface PutResponse<V>{
    record Created<V>(V data) implements PutResponse<V>{};
    record Updated<V>(V data) implements PutResponse<V>{};
}
