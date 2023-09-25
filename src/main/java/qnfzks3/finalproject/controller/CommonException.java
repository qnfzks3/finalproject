package qnfzks3.finalproject.controller;



import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CommonException {
    //예외처리는 HTTP 상태 코드로 응답하는 @ResponseStatus , 컨트롤러 기반의 @ExceptionHandler,@ControllerAdvice가 있다.
    //10장 예외처리
    @ExceptionHandler(RuntimeException.class)
    private ModelAndView handleErrorCommon(Exception e){
        ModelAndView mv = new ModelAndView();
        mv.addObject("exception",e);
        mv.setViewName("errorCommon");

        return mv;
    }

}


/*
@ResponseStatus:
   @ResponseStatus 어노테이션은 컨트롤러 메서드가 특정 예외를 처리할 때 HTTP 응답 상태 코드를 지정하는 데 사용됩니다.
   예를 들어, 특정 예외가 발생하면 해당 예외를 처리하는 메서드 위에 @ResponseStatus 어노테이션을 사용하여 HTTP 응답 상태 코드를 지정할 수 있습니다.
   예를 들어, @ResponseStatus(HttpStatus.NOT_FOUND)를 사용하면 404 상태 코드를 반환할 수 있습니다.
   이 어노테이션은 예외 클래스 레벨 또는 메서드 레벨에서 사용할 수 있으며,
   * 특정 예외가 발생했을 때 원하는 HTTP 상태 코드를 설정하고자 할 때 유용합니다.

@ExceptionHandler:
   @ExceptionHandler 어노테이션은 컨트롤러 클래스 내의 특정 메서드에 적용하여 그 메서드가 특정 예외를 처리하도록 지정합니다.
   예외가 발생하면 해당 예외를 처리하는 메서드가 실행되며, 이 메서드 내에서 예외 처리 로직을 작성할 수 있습니다.
   이 어노테이션은 특정 컨트롤러 클래스 내에서 예외 처리를 위해 사용되며,
   * 해당 컨트롤러의 메서드에서 발생하는 예외를 처리하는 데 사용됩니다.

@ControllerAdvice:
   @ControllerAdvice 어노테이션은 전역 예외 처리를 구현하기 위한 어노테이션입니다.
   이 어노테이션을 사용하면 여러 컨트롤러에서 발생하는 예외를 전역적으로 처리할 수 있습니다.
   @ControllerAdvice 어노테이션이 지정된 클래스 내에 @ExceptionHandler 메서드를 작성하여 어떤 예외가 발생했을 때 어떻게 처리할 것인지 정의합니다.
   이 방식은 모든 컨트롤러에서 발생하는 예외를 일관된 방식으로 처리하고자 할 때 유용하며, 전체 애플리케이션에 일관성 있는 예외 처리를 제공합니다.


    예외를 어떻게 처리할지 선택하는 것은 애플리케이션의 요구사항과 복잡성에 따라 다를 수 있습니다.
    일반적으로 @ExceptionHandler는 특정 컨트롤러 클래스 내에서 예외 처리를 정의하는 데 사용되고,
    @ControllerAdvice는 전역 예외 처리를 위해 사용됩니다.
    @ResponseStatus는 예외가 발생했을 때 HTTP 응답 상태 코드를 지정하는 데 사용됩니다.
    선택은 개발자가 애플리케이션의 예외 처리 요구사항을 고려하여 결정해야 합니다.
*/
