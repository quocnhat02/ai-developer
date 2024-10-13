def sum_all(*arg):
    print(sum(arg))


sum_all(1, 2, 3)


def all_info(**info):
    for key, value in info.items():
        print(f"{key}: {value}")


all_info(name="Nhat", age=22)


def fibonacci(n):
    if n < 2:
        return 1
    return fibonacci(n - 2) + fibonacci(n - 1)


print(fibonacci(5))
