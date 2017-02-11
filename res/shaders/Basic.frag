#version 330 core

layout (location = 0) out vec4 color;

in vec4 pos;
in vec2 texCoord;

uniform sampler2D tex;

void main(){
	color = texture(tex, texCoord);
}