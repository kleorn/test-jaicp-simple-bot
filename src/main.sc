require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: / #для группировки

# state: StateName || noContext = True - перейти в стейт без контекста (остаемся в контексте текущего стейта

    state: Start
        #активаторы: q - паттерн, intent - интент CAILA, event - системное событие (напр. noMatch)
        #! - глобальный активатор
        #a - может быть несколько. {{$var.esre.1}} - подстановка переменной
        # buttons:
        #   "Кнопка 1" -> /Bye
        # patterns - именованные паттерны, лучше хранить в одном файле patterns.sc и в алфавитном порядке
        
        #go! - перейти к другому стейту и вывести ответ
        #go - перейти к другому стейту, но ничего не выводить
        # если 2 go - сработает первый
        
        # requre: filename
        #       module = moduleName
        
        q!: $regex</start>
        a: Начнём.

    state: Hello
        intent!: /привет
        a: Привет привет
        buttons:
            "Даров"
            "Сам привет" -> /Bye

    state: Bye
        intent!: /пока
        random:
            a: Пока пока
            a: Досвидос
            a: Ариведерчи

    state: NoMatch
        event!: noMatch
        a: Я не понял. Вы сказали: {{$request.query}}

    state: Match
        event!: match
        a: {{$context.intent.answer}}