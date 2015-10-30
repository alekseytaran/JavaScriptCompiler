"use strict";
var memory = [];
var pointer = 0;
var currentValue = '';
for(var x =0; x < 30000; x++){
memory[x] = 0;
}
memory[pointer] += 8;
for( ; memory[pointer] != 0; ) {
pointer += 1;
memory[pointer] += 4;
memory[pointer] += 0;
memory[pointer] += 0;
memory[pointer] += 0;
for( ; memory[pointer] != 0; ) {
pointer += 1;
memory[pointer] += 2;
memory[pointer] += 0;
pointer += 1;
memory[pointer] += 3;
memory[pointer] += 0;
memory[pointer] += 0;
pointer += 1;
memory[pointer] += 3;
memory[pointer] += 0;
memory[pointer] += 0;
pointer += 1;
memory[pointer] += 1;
pointer -= 4;
pointer -= 0;
pointer -= 0;
pointer -= 0;
memory[pointer] -= 1;
}
pointer += 1;
memory[pointer] += 1;
pointer += 1;
memory[pointer] += 1;
pointer += 1;
memory[pointer] -= 1;
pointer += 2;
pointer += 0;
memory[pointer] += 1;
for( ; memory[pointer] != 0; ) {
pointer -= 1;
}
pointer -= 1;
memory[pointer] -= 1;
}
pointer += 2;
for(let i = 0; i < 1; i++) {
currentValue += String.fromCharCode(memory[pointer]);
}
pointer += 1;
memory[pointer] -= 3;
for(let i = 0; i < 1; i++) {
currentValue += String.fromCharCode(memory[pointer]);
}
memory[pointer] += 7;
for(let i = 0; i < 2; i++) {
currentValue += String.fromCharCode(memory[pointer]);
}
memory[pointer] += 3;
for(let i = 0; i < 1; i++) {
currentValue += String.fromCharCode(memory[pointer]);
}
pointer += 2;
for(let i = 0; i < 1; i++) {
currentValue += String.fromCharCode(memory[pointer]);
}
pointer -= 1;
memory[pointer] -= 1;
for(let i = 0; i < 1; i++) {
currentValue += String.fromCharCode(memory[pointer]);
}
pointer -= 1;
for(let i = 0; i < 1; i++) {
currentValue += String.fromCharCode(memory[pointer]);
}
memory[pointer] += 3;
for(let i = 0; i < 1; i++) {
currentValue += String.fromCharCode(memory[pointer]);
}
memory[pointer] -= 6;
for(let i = 0; i < 1; i++) {
currentValue += String.fromCharCode(memory[pointer]);
}
memory[pointer] -= 8;
for(let i = 0; i < 1; i++) {
currentValue += String.fromCharCode(memory[pointer]);
}
pointer += 2;
memory[pointer] += 1;
for(let i = 0; i < 1; i++) {
currentValue += String.fromCharCode(memory[pointer]);
}
pointer += 1;
memory[pointer] += 2;
for(let i = 0; i < 1; i++) {
currentValue += String.fromCharCode(memory[pointer]);
}
alert(currentValue);
