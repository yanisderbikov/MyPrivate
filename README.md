# yandex week intern offer & yandex week offer

>Решены все 5 задач для стажировки в яндексе, но валидатор не принимал. На тесте 5 или далее решение не справлялось. Прошла только одна задача - B
>
> Ниже приведены ссылки на PDF файлы, где лежат оригиналы заданий. 

## задача А
### Условие:
Тур по городу N для Кати, Маши и Наташи будет удачным, если они посмотрят самые ожидаемые 
достопримечательности в нужном порядке. Составьте кратчайшую последовательность достопримечательностей 
для посещения, чтобы пожелания были выполнены.

Даны три последовательности чисел. В любой из последовательностей числа могут повторяться.
Вам нужно найти супер-последовательность. Супер-последовательность – это последовательность минимальной 
длины, чтобы в ней были все три последовательности непрерывными фрагментами.

### Формат ввода:
Ввод состоит из трех строк. Первый элемент каждой строки ni (1 ≤ ni ≤ 100) – число элементов 
в i-й последовательности. Далее идут ni положительных чисел, не превосходящих 100, – элементы 
последовательности. Все числа в строках разделены пробелами.

### Формат вывода:
Первая строка вывода содержит одно число k – длина супер-последовательности. Вторая строка содержит 
k разделенных пробелами чисел – элементы супер- последовательности.

#### Пример №1
__Ввод__ | __Вывод__
:----- | :---
2 1 2 | 4 
2 2 3 | 1 2 3 1   
2 3 1 | 

#### Пример №2
__Ввод__ | __Вывод__
:----- | :---
1 2 | 3
2 1 2  | 3 1 2 
3 3 1 2 | 

#### Пример №3
__Ввод__ | __Вывод__
:----- | :---
5 1 2 3 4 5| 12
4 9 10 11 12 | 1 2 3 4 5 6 7 8 9 10 11 12
5 5 6 7 8 9 | 

***
## Задача В
### Условие:
Красотой массива назовем наибольшее количество подряд идущих в нем четных чисел. Дан массив a, 
состоящий из n целых чисел. Разрешается не более k раз выбрать любые два элемента этого массива и 
поменять их местами.
Найдите наибольшую возможную красоту массива после применения указанных операций.
### Формат ввода:
В первой строке записаны числа n и k (1 ≤ k ≤ n ≤ 10^6)
Во второй строке записаны числа a1, a2, ... , an (-10^9 ≤ ai ≤ 10^9).
### Формат вывода:
Выведите единственное число — ответ на задачу.
#### Пример №1
__Ввод__ | __Вывод__
:----- | :---
5 1 | 3 
-1 2 4 3 0 |    

#### Пример №2
__Ввод__ | __Вывод__
:----- | :---
4 1  | 4
2 4 6 8 |  

#### Пример №3
__Ввод__ | __Вывод__
:----- | :---
5 1 | 3
0 1 2 3 4 |

#### Пример №4
__Ввод__ | __Вывод__
:----- | :---
6 2 | 4
0 2 1 -1 -2 4 |
### Примечания
В первом тесте можно можно поменять местами пару чисел 1 и 0. Тогда в результате получим четный 
подотрезок 0, 2, 4 длины 3. Подотрезок длины больше 3, очевидно, получить нельзя.

```
Solution solution = new Solution();
```

***

### Другие задачи по ссылке ниже
**Задача A** |            **Задача B**            |           **Задача C**            |           **Задача D**            | **Задача E**
:------: |:----------------------------------:|:---------------------------------:|:---------------------------------:| :----:
![задача №1](picturesTasks/1.pdf) | ![задача №2](picturesTasks/2.pdf)  | ![задача №3](picturesTasks/3.pdf) | ![задача №4](picturesTasks/4.pdf) | ![задача №5](picturesTasks/5.pdf)




## my [Telegram](https://t.me/yanderbikov)
