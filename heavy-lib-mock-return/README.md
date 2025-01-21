# External Library Mocking — Then Return

The goal of this task is to practice using the `Mockito#thenReturn` method.

Duration: _15 minutes_

## Description

In this task, you will be provided with three types:

1. `ClientService` - which you will implement
2. `ClientRepository` - which you will stub
3. `ClientResponse` - which you will return in your stub

`ClientRepository` consists of two methods:
1. `definedId` is a utility method that is used to fetch an `id` for stubbing.
2. `findById(long)` returns an instance of `ClientResponse` (you need to mock this one).

You *must not* provide an explicit implementation of `ClientRepository`.
This means you may not:
* Create a class that implements this interface
* Create an anonymous class that implements this interface

You'll be provided with a mock for this interface; all you have to do is configure it
according to the requirements.

`ClientResponse` should not be modified.

`ClientService` has a constructor that accepts an instance of `ClientRepository` and the `search(long)` method.
The `search(long)` method *must not* be modified; the only place where you put your code is
the constructor.
In the constructor, you will receive a mock object for `ClientRepository`, and in the same constructor,
you should configure it as described in the requirements.

## Requirements

* The `Mockito` library is used.
* No explicit instance of `ClientRepository` is created.
* When calling `ClientRepository#findById(long)` with a value equal to the result `definedId()`,
  the `ClientResponse` must be returned.
  Otherwise, `null` must be returned.
* The `ClientResponse` must have:
  * `id` = `definedId()`
  * `name` = `Lou`
  * `surname` = `Tenat`

## Examples

```java
// repository is defined in tests
ClientService service = new ClientService(repository); // should not throw any exception

// The positive case
        ClientResponse response = service.search(repository.definedId());
        assert response != null; // true
        assert response.id() == repository.definedId(); // true
        assert "Lou".equals(response.name()); // true
        assert "Tenat".equals(response.surname()); // true

// The negative case
        ClientResponse nullResponse = service.search(repository.definedId() + 1);
        assert nullResponse == null; // true
```
