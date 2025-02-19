class CodeConverter:
    regex = '\d{1,4}' # \d : (0~9)숫자, {1,4} : 1~4자리 까지

    def to_python(self, value):
        return int(value)

    def to_url(self, value):
        return str(value)