Создать утилиту командной строки, которая обрабатывает данные способом, описанным ниже, и возвращает результат в STDOUT.

ВХОДНЫЕ ДАННЫЕ:
В командной строке указывается имя текстового файла. Текстовый файл с email-адресами (разделитель — перевод строки). Пример:
info@mail.ru
support@vk.com
ddd@rambler.ru
roxette@mail.ru
sdfsdf@@@@@rdfdf
example@localhost
иван@иванов.рф
ivan@xn--c1ad6a.xn--p1ai
СУТЬ ОБРАБОТКИ:
Группировка адресов по имени домена, подсчёт email-адресов для каждого домена.
ВЫХОДНЫЕ ДАННЫЕ:
Имена доменов и количество адресов в каждом домене. Сортировка по количеству адресов в домене, по убыванию. Отдельной строкой — количество невалидных адресов. Пример:
mail.ru	2
vk.com	1
rambler.ru	1
INVALID	1
Созданная программа, должна быть максимально покрыта автоматическими тестами (юнит тесты и т. п.), валидирующими все аспекты функционирования программы и покрывающими максимальное количество кода программы.

Несмотря на игрушечный пример оценивается качество кода, его форматирование (пробелы, отступы, пустые строки, выделение смысловых блоков и т.п.), модульность, соответствие «лучшим практикам» Perl-программирования и, главное, способности писать автотесты.
