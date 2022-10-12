require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: / #для группировки
# зависимости - см. zb-common. newOfftopic - ловит оффтоп

# init: - выполняется один раз при запуске бота
# state: StateName || noContext = true - перейти в стейт без контекста (остаемся в контексте текущего стейта

# параметры стейтов:
# noContext - перейти без смены контекста, 
# modal - не выпускает в другие глобальные активаторы, пока не дашь ответ для этого стейта. дает noMatch. выход только по go или q || fromState = /theme/state
# 

    state: Start
        #активаторы: q - паттерн, intent - интент CAILA, event - системное событие (напр. noMatch)
        #   q: город || fromState = /theme/state - переход только из стейти или дочерних
        #   q: город || fromState = /theme/state, onlyThisState = true - переход только из стейта (без дочерних)
        #! - глобальный активатор
        #a - может быть несколько. {{$var.esre.1}} - подстановка переменной
        # buttons:
        #   "Кнопка 1" -> /Bye
        # patterns - именованные паттерны, лучше хранить в одном файле patterns.sc и в алфавитном порядке
        #   пример испльзования: q: * $City *
        
        #go! - перейти к другому стейту и вывести ответ
        #go - перейти к другому стейту, но ничего не выводить
        # если 2 go - сработает первый
        
        # requre: filename (относительно папки src) - лучше все в файле requirements.sc
        #       module = sys.zb-common
        
        # script: - код JS5. Не писать в сценарий больше 7-10 строк, выносить в функции
        # - для интеграций, логики итд!
        # if:, elsif:, else: - внутри них можно помещать другие теги: q,s и т.д.
        
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