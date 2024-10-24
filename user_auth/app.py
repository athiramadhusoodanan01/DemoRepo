from flask import Flask, request, jsonify
from auth import hash_password, get_user_from_db, generate_token
from middleware import token_required

app = Flask(__name__)

users = {
    'user1': '5f4dcc3b5aa765d61d8327deb882cf99',
}

@app.route('/login', methods=['POST'])
def login():
    data = request.json
    username = data.get('username')
    password = data.get('password')

    user = get_user_from_db(username)
    if not user:
        return jsonify({'error': 'User not found'}), 404

    password_hash = hash_password(password)
    if password_hash == user['password_hash']:
        token = generate_token(username)
        return jsonify({'message': 'Login successful!', 'token': token}), 200
    else:
        return jsonify({'error': 'Invalid credentials'}), 401

@app.route('/register', methods=['POST'])
def register():
    data = request.json
    username = data.get('username')
    password = data.get('password')

    if username in users:
        return jsonify({'error': 'User already exists'}), 409

    users[username] = hash_password(password)

    return jsonify({'message': 'Registration successful!'}), 201

@app.route('/protected', methods=['GET'])
@token_required
def protected():
    return jsonify({'message': 'This is a protected route. You are authenticated!'}), 200

if __name__ == '__main__':
    app.run(debug=True)
