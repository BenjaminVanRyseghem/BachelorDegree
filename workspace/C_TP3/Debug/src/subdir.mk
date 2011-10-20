################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
C_SRCS += \
../src/mcolrm.c \
../src/mcut.c \
../src/mgrep.c \
../src/mlook.c \
../src/readl.c 

OBJS += \
./src/mcolrm.o \
./src/mcut.o \
./src/mgrep.o \
./src/mlook.o \
./src/readl.o 

C_DEPS += \
./src/mcolrm.d \
./src/mcut.d \
./src/mgrep.d \
./src/mlook.d \
./src/readl.d 


# Each subdirectory must supply rules for building sources it contributes
src/%.o: ../src/%.c
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C Compiler'
	gcc -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@:%.o=%.d)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


