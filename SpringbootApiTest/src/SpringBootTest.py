from flask import Flask,request,render_template
import boto3, json
from werkzeug.utils import secure_filename
from socket import *

app = Flask(__name__)

@app.route('/receive_string', methods=["POST"])
def receive_string():
    #String으로 부터 JSON 객체를 전달 받음
    dto_json = request.get_json()

    #dto_json을 dumps 메서드를 활용하여 response에 저장
    response = json.dumps(dto_json,ensure_ascii=False)

    #Spring에서 받은 데이터를 출력해서 확인
    print(dto_json)

    return response

if __name__ == '__main__':
      app.run(port=5000, debug=True)



