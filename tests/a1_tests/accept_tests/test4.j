.class public test4
.super java/lang/Object

.method public static arrayMax([I)I
    .limit locals 18
    .limit stack 50
;       T2 := 0
    ldc 0
    istore 2
;       T3 := T0[T2]
    aload 0
    iload 2
    iaload
    istore 3
;       T4 := 1
    ldc 1
    istore 4
;       T5 := T0[T4]
    aload 0
    iload 4
    iaload
    istore 5
;       T6 := T3 I< T5
    iload 3
    iload 5
    isub
    iflt L_0
    ldc 0
    goto L_1
L_0:
    ldc 1
L_1:
    istore 6
;       T7 := Z! T6
    iload 6
    ifne L_2
    iconst_1
    goto L_3
L_2:
    iconst_0
L_3:
    istore 7
;       IF T7 GOTO L0
    iload 7
    ifne L0
;       T8 := 1
    ldc 1
    istore 8
;       T9 := T0[T8]
    aload 0
    iload 8
    iaload
    istore 9
;       T1 := T9
    iload 9
    istore 1
;       GOTO L1
    goto L1
;       L0:
L0:
;       T10 := 0
    ldc 0
    istore 10
;       T11 := T0[T10]
    aload 0
    iload 10
    iaload
    istore 11
;       T1 := T11
    iload 11
    istore 1
;       L1:
L1:
;       T12 := 2
    ldc 2
    istore 12
;       T13 := T0[T12]
    aload 0
    iload 12
    iaload
    istore 13
;       T14 := T1 I< T13
    iload 1
    iload 13
    isub
    iflt L_4
    ldc 0
    goto L_5
L_4:
    ldc 1
L_5:
    istore 14
;       T15 := Z! T14
    iload 14
    ifne L_6
    iconst_1
    goto L_7
L_6:
    iconst_0
L_7:
    istore 15
;       IF T15 GOTO L2
    iload 15
    ifne L2
;       T16 := 2
    ldc 2
    istore 16
;       T17 := T0[T16]
    aload 0
    iload 16
    iaload
    istore 17
;       T1 := T17
    iload 17
    istore 1
;       L2:
L2:
;       RETURN T1
    iload 1
    ireturn
.end method


.method public static __main()V
    .limit locals 8
    .limit stack 50
;       T0 := NEWARRAY I 3
    ldc 3
    newarray int
    astore 0
;       T1 := 0
    ldc 0
    istore 1
;       T2 := 1
    ldc 1
    istore 2
;       T0[T1] := T2
    aload 0
    iload 1
    iload 2
    iastore
;       T3 := 1
    ldc 1
    istore 3
;       T4 := 7
    ldc 7
    istore 4
;       T0[T3] := T4
    aload 0
    iload 3
    iload 4
    iastore
;       T5 := 2
    ldc 2
    istore 5
;       T6 := 5
    ldc 5
    istore 6
;       T0[T5] := T6
    aload 0
    iload 5
    iload 6
    iastore
;       T7 := CALL arrayMax(T0)
    aload 0
    invokestatic test4/arrayMax([I)I
    istore 7
;       PRINTI T7
    getstatic java/lang/System/out Ljava/io/PrintStream;
    iload 7
    invokevirtual java/io/PrintStream/print(I)V
    return
.end method


;--------------------------------------------;
;                                            ;
; Boilerplate                                ;
;                                            ;
;--------------------------------------------;
.method public static main([Ljava/lang/String;)V
    ; set limits used by this method
    .limit locals 1
    .limit stack 4
    invokestatic test4/__main()V
    return
.end method

; standard initializer
.method public <init>()V
    aload_0
    invokenonvirtual java/lang/Object/<init>()V
    return
.end method