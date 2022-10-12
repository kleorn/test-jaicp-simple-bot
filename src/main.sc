require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: / #для группировки



    state: Start
        #активаторы: q - паттерн, intent - интент CAILA, event - системное событие (напр. noMatch)
        #! - глобальный активатор
        #a - может быть несколько. {{$var.esre.1}} - подстановка переменной
        #go
        q!: $regex</start>
        a: Начнём.

    state: Hello
        intent!: /привет
        a: Привет привет

    state: Bye
        intent!: /пока
        a: Пока пока

    state: NoMatch
        event!: noMatch
        a: Я не понял. Вы сказали: {{$request.query}}

    state: Match
        event!: match
        a: {{$context.intent.answer}}